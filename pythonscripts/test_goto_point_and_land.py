#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
import time
from dronekit import connect, VehicleMode, LocationGlobalRelative, LocationGlobal
import math


# Set up option parsing to get connection string
import argparse
parser = argparse.ArgumentParser(description='Commands vehicle')
parser.add_argument('--connect',
                    help="Vehicle connection target string. If not specified, SITL automatically started and used.")
args = parser.parse_args()

connection_string = args.connect
sitl = None


# Start SITL if no connection string specified
if not connection_string:
    import dronekit_sitl
    sitl = dronekit_sitl.start_default()
    connection_string = sitl.connection_string()


# Connect to the Vehicle
print('Initialising Connection to vehicle on: %s' % connection_string)
vehicle = connect(connection_string, wait_ready=True)

# Change to current location



def arm_and_takeoff(aTargetAltitude):
    """
    Arms vehicle and fly to aTargetAltitude.
    """

    print("Basic pre-arm checks")
    # Don't try to arm until autopilot is ready
    while not vehicle.is_armable:
        print(" Waiting for vehicle to initialise...")
        time.sleep(1)

    print("Motors being Armed")
    # Copter should arm in GUIDED mode
    vehicle.mode = VehicleMode("GUIDED")
    vehicle.armed = True
   # while vehicle.mode.name != 'GUIDED':
    #        print('  ... polled mode: {0}'.format('Guided'))
     #       time.sleep(1)

    # Confirm vehicle armed before attempting to take off
    while not vehicle.armed:
        print(" Waiting for arming...")
        time.sleep(1)

    print("Taking off!")
    vehicle.simple_takeoff(aTargetAltitude)  # Take off to target altitude

    # Wait until the vehicle reaches a safe height before processing the goto
    #  (otherwise the command after Vehicle.simple_takeoff will execute
    #   immediately).
    while True:
        print(" Altitude: ", vehicle.location.global_relative_frame.alt)
        # Break and return from function just below target altitude.
        if vehicle.location.global_relative_frame.alt >= aTargetAltitude * 0.95:
            print("Target altitude achieved")
            break
        time.sleep(1)
        
#Callback to print the location in global frames. 'value' is the updated value
def location_callback(self, attr_name, value):
    print ("Location (Global): ", value)


        
def get_distance_metres(aLocation1, aLocation2):
    """
    Returns the ground distance in metres between two LocationGlobal objects.

    This method is an approximation, and will not be accurate over large distances and close to the 
    earth's poles. It comes from the ArduPilot test code: 
    https://github.com/diydrones/ardupilot/blob/master/Tools/autotest/common.py
    """
    dlat = aLocation2.lat - aLocation1.lat
    dlong = aLocation2.lon - aLocation1.lon
    return math.sqrt((dlat*dlat) + (dlong*dlong)) * 1.113195e5
    
def monitor_distance(targetDistance,targetLocation):
    while vehicle.mode.name=="GUIDED": #Stop action if we are no longer in guided mode.
    #print "DEBUG: mode: %s" % vehicle.mode.name
        remainingDistance=get_distance_metres(vehicle.location.global_relative_frame, targetLocation)
        print("Reaching target in ",remainingDistance," metres ")
        #if remainingDistance<=targetDistance*0.01: #Just below target, in case of undershoot.
        if remainingDistance<=1:
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
    
# Add a callback `location_callback` for the `global_frame` attribute.
vehicle.add_attribute_listener('home_location', location_callback)

cmds = vehicle.commands
cmds.download()
cmds.wait_ready()
print ("\n Vehicle Home Location: %s" % vehicle.home_location)
homelocation=vehicle.home_location

#####TO FIRST POINT######
arm_and_takeoff(15)
time.sleep(10)

cmds = vehicle.commands
cmds.download()
cmds.wait_ready()
print ("\n Vehicle Home Location: %s" % vehicle.home_location)

print("Airspeed set to 5 m/s")
vehicle.airspeed = 5


print("Going towards set co-ordinates...")
point1 = LocationGlobalRelative(53.503310, -6.450093, 5)
targetDistance = get_distance_metres(vehicle.location.global_relative_frame, point1)
    
    
vehicle.simple_goto(point1)
monitor_distance(targetDistance,point1)
time.sleep(10)


print("Landing....")
vehicle.mode = VehicleMode("LAND")
time.sleep(45)

# Close vehicle object before exiting script
print("Close vehicle object")
vehicle.close()

# Shut down simulator if it was started.
if sitl:
    sitl.stop()
    
    
