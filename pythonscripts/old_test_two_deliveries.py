
from __future__ import print_function
import time
from dronekit import connect, VehicleMode, LocationGlobalRelative, LocationGlobal
import math
import mysql.connector


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
   # while vehicle.mode.name != 'GUIDED':
    #        print('  ... polled mode: {0}'.format('Guided'))
     #       time.sleep(1)

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


        
def get_distance(location1, location2):
    #Returns distance in metres between 2 gps co-ordinates
    latitudeDistance = location2.lat - location1.lat
    longitudeDistance = location2.lon - location1.lon
    return math.sqrt((latitudeDistance*latitudeDistance) + (longitudeDistance*longitudeDistance)) * 1.113195e5
    
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
    

def get2coordinates():
                        
    mycursor = db.cursor()

#mycursor.execute("SHOW TABLES")

    mycursor.execute("SELECT longitude, latitude FROM productorder")

    coordinates = mycursor.fetchmany(2)

    return coordinates;

    
# Add a callback `location_callback` for the `global_frame` attribute.
vehicle.add_attribute_listener('home_location', location_callback)

#Store starting homelocation in variable to update homelocation of drone to original home location when it takes off from another point
cmds = vehicle.commands
cmds.download()
cmds.wait_ready()
print ("\n Vehicle Home Location: %s" % vehicle.home_location)
homelocation=vehicle.home_location

coordinates=get2coordinates();

i=1;
point={};
for row in coordinates:
                print("Longitude: ", row[0])
                print("Latitude: ", row[1])
                point[i]=[row[0],row[1]];
                i+=1;
                print("\n")
                
print(point)


#point1 = LocationGlobalRelative(float(point[1][0]), float(point[1][1]), 5)
#point1 = LocationGlobalRelative(53.503310, point[1][1], 5)

print(53.503310==float(point[1][0]));


#point2 = LocationGlobalRelative(float(point[2][0]), float(point[2][1]), 5)


#####TO FIRST POINT######
fly_to_set_altitude(15)
time.sleep(1)

cmds = vehicle.commands
cmds.download()
cmds.wait_ready()
print ("\n Vehicle Home Location: %s" % vehicle.home_location)

print("Airspeed set to 5 m/s")
vehicle.airspeed = 5




print("Going towards point1...")
#point1 = LocationGlobalRelative(53.503310, -6.450093, 5)
point1 = LocationGlobalRelative(53.5032596,-6.4508143, 5)
    
    
vehicle.simple_goto(point1)
monitor_distance(point1)
time.sleep(10)

print("Landing....")
vehicle.mode = VehicleMode("LAND")
time.sleep(45)

fly_to_set_altitude(15)
set_home(homelocation)
time.sleep(10)


####TO SECOND POINT######
print("Airspeed set to 5 m/s")
vehicle.airspeed = 5

#53.502979, -6.451012
print("Going towards point2...")
#point2 = LocationGlobalRelative(53.502956, -6.450588, 5)
point2 = LocationGlobalRelative(53.5031206,-6.4508545, 5)

vehicle.simple_goto(point2)
monitor_distance(point2)

print("Landing....")
vehicle.mode = VehicleMode("LAND")
time.sleep(45)

#ly_to_set_altitude(15)
set_home(homelocation)
time.sleep(10)

print("Returning to Launch")
vehicle.mode = VehicleMode("RTL")

# Close vehicle object before exiting script
print("Close vehicle object")
vehicle.close()

db.close()
# Shut down simulator if it was started.
if sitl:
    sitl.stop()
    
    
