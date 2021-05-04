
from __future__ import print_function
import time
from datetime import datetime
from dronekit import connect, VehicleMode, LocationGlobalRelative, LocationGlobal
import math
import mysql.connector
import threading
import geopy.distance
import sys


# Set up option parsing to get connection string
import argparse
parser = argparse.ArgumentParser(description='Commands vehicle')
parser.add_argument('--connect',
                    help="Vehicle connection target string. If not specified, SITL automatically started and used.")
args = parser.parse_args()

connection_string = args.connect
sitl = None

db = mysql.connector.connect(user='root', password='root',
                                host='localhost',
                                database='fyp')
                                
mycursor = db.cursor()
flightid=0;
# Start SITL if no connection string specified
if not connection_string:
    import dronekit_sitl
    sitl = dronekit_sitl.start_default()
    connection_string = sitl.connection_string()


# Connect to the Vehicle
print('Initialising Connection to vehicle on: %s' % connection_string)
vehicle = connect(connection_string, wait_ready=True)

# Change to current location

def fly_to_set_altitude(targetAltitude):
    #Vehicle arms, initiates takeoff and flies to set altitude
    
    print("Pre-arm checks in process")
    # Don't try to arm until autopilot is ready
    while not vehicle.is_armable:
        print(" Waiting for vehicle to initialise...")
        time.sleep(1)

    print("Motors being Armed")
    
    # Copter must be in GUIDED Mode to arm
    vehicle.mode = VehicleMode("GUIDED")
    vehicle.armed = True
   
    # Check if vehicle is armed before taking off
    while not vehicle.armed:
        print(" Waiting for arming...")
        time.sleep(1)

    print("Taking off!")
    vehicle.simple_takeoff(targetAltitude)  # Take off to target altitude

    while True:
        print(" Altitude: ", vehicle.location.global_relative_frame.alt)
        # Break and return from function just below target altitude.
        if vehicle.location.global_relative_frame.alt >= targetAltitude * 0.95:
            print("Target altitude achieved")
            break
        time.sleep(1)
        
#Callback to print the location in global frames. 'value' is the updated value
def location_callback(self, attr_name, value):
    print ("Location (Global): ", value)

def goto_point_and_land(number,location):
    print("Airspeed set to 5 m/s")
    vehicle.airspeed = 5
    if(isinstance(number,int)):
        print("Going towards point",number,"...")
 
    vehicle.simple_goto(location)
    monitor_distance(location)
    time.sleep(5)

    print("Landing....")
    vehicle.mode = VehicleMode("LAND")
    while True:
        print(" Altitude: ", vehicle.location.global_relative_frame.alt)
        # Break and return from function just below target altitude.
        if vehicle.location.global_relative_frame.alt <= 1:
            print("Brace for impact...")
            break
        time.sleep(1)
    time.sleep(3)
    print("Landed")
    time.sleep(20)
    
def monitor_attributes():
    while True:
        battery=vehicle.battery.level;
        #if vehicle.battery.level is none it means the drone battery is low i.e 1
        if(battery==None):
            battery=1;
        lat=vehicle.location.global_frame.lat;
        lon=vehicle.location.global_frame.lon;
        alt=vehicle.location.global_relative_frame.alt;
        mycursor.execute("UPDATE droneflight SET currentLongitude = %s, currentLatitude= %s, altitude= %s, batteryPercentage= %s WHERE id = %s ",
        (lon,lat,alt,battery,flightid))
        time.sleep(5);
        
def get_dist(location1, location2):
    earthRadius = 6371000;
    latitudeDistance = location2.lat - location1.lat
    longitudeDistance = location2.lon - location1.lon
    a = math.sin(latitudeDistance/2) * math.sin(latitudeDistance/2) + math.cos(math.radians(location1.lat)) * math.cos(math.radians(location2.lat)) * math.sin(longitudeDistance/2) * math.sin(longitudeDistance/2);
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a));
    dist = (earthRadius * c);
    return dist;

    
def get_distance(location1, location2):
    #Returns distance in metres between 2 gps co-ordinates
    current=(location1.lat,location1.lon)
    target=(location2.lat,location2.lon)
    return geopy.distance.vincenty(current,target).km *1000;
    
def monitor_distance(targetLocation):
    #This method prints the distance left between the drone and target location until targetLocation is reached
    while vehicle.mode.name=="GUIDED": 
        distanceRemaining=get_distance(vehicle.location.global_relative_frame, targetLocation)
        print("Reaching target in",distanceRemaining," metres ")
        #stop if drone is within one metre of targetLocation
        if distanceRemaining<=1:
            print("Reached target")
            break;
        time.sleep(2)
	
def set_home(homelocation):
    cmds = vehicle.commands
    cmds.download()
    cmds.wait_ready()
    vehicle.home_location=homelocation
    print ("\n Home location: %s" % vehicle.home_location)
    cmds.clear()
    time.sleep(2)
    
def makeDelivery(num,lat,long):
    fly_to_set_altitude(5)
    time.sleep(1)
    waypoint = LocationGlobalRelative(lat, long, 5)
    goto_point_and_land(num,waypoint)
    mycursor.execute("UPDATE productorder SET orderstatus= %s WHERE id = %s ",("delivered",ids[num-1]))

    

def getcoordinates():                   
    mycursor.execute("SELECT id,latitude, longitude FROM productorder WHERE orderstatus='ordered'")

    coordinates = mycursor.fetchmany(3)

    return coordinates;

def start_attribute_thread():
    thread = threading.Thread(target=monitor_attributes, name="Attributes");
    thread.daemon=True;
    thread.start();
    
# Add a callback `location_callback` for the `global_frame` attribute.
vehicle.add_attribute_listener('home_location', location_callback)

#Store starting homelocation in variable to update homelocation of drone to original home location when it takes off from another point
cmds = vehicle.commands
cmds.download()
cmds.wait_ready()
print ("\n Vehicle Home Location: %s" % vehicle.home_location)
homelocation=vehicle.home_location

coordinates=getcoordinates();
 
i=1;
ids=list();
point={};
pointsarr=[]
if(len(coordinates)==0):
    print("No Orders Found");
    sys.exit();
for row in coordinates:
                print("ID: ",row[0])
                print("Latitude: ", row[1])
                print("Longitude: ", row[2])
                mycursor.execute("UPDATE productorder SET orderstatus= %s WHERE id = %s ",("in transit",row[0]))
                point[i]=[row[1],row[2]];
                ids.append(row[0]);
                i+=1;
                print("\n")
                
print(point)

waypoints=len(point);
print("WAYPOINTS ",waypoints);
default=0;

mycursor.execute("INSERT INTO droneflight(currentLongitude,currentLatitude,altitude, batteryPercentage,duration,numWaypoints)" \
"Values(%s,%s,%s,%s,%s,%s)",(default,default,default,default,default,waypoints));

if mycursor.lastrowid:
    print('last insert id', mycursor.lastrowid)
    flightid=mycursor.lastrowid
    print(type(flightid));
else:
    print('last insert id not found')

start=datetime.now();



start_attribute_thread();
cmds = vehicle.commands
cmds.download()
cmds.wait_ready()
print ("\n Vehicle Home Location: %s" % vehicle.home_location)

#####DELIVER TO EACH LOCATION######
num=1;
for waypoint in point:
    makeDelivery(num,float(point[waypoint][0]),float(point[waypoint][1]));
    num+=1;
    
fly_to_set_altitude(5)
set_home(homelocation)
time.sleep(1)

homepoint = LocationGlobalRelative(homelocation.lat, homelocation.lon, 5)

print("Returning to Launch")
goto_point_and_land("home",homepoint)

# Close vehicle object before exiting script
print("Close vehicle object")
vehicle.close()
scriptRunning=False;

duration=datetime.now() - start
print("Duration: ",duration);
mycursor.execute("UPDATE droneflight SET duration= %s WHERE id = %s ",(duration,flightid))

db.close()
# Shut down simulator if it was started.
if sitl:
    sitl.stop()
    

    
    
