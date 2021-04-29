print "Start simulator (SITL)"
import dronekit_sitl
from pymavlink import mavutil
#sitl = dronekit_sitl.start_default()
#connection_string = sitl.connection_string()
##connection_string = '115200'
#change to 14550
#connection_string = '127.0.0.1:14552'


# Import DroneKit-Python
from dronekit import connect, VehicleMode
import time

# Connect to the Vehicle.
#print("Connecting to vehicle on: %s" % (connection_string,))
#vehicle = connect(connection_string, wait_ready=True)

# Set up option parsing to get connection string
import argparse
parser = argparse.ArgumentParser(description='Commands vehicle.')
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
print('Connecting to vehicle on: %s' % connection_string)
vehicle = connect(connection_string, wait_ready=True)


# Get some vehicle attributes (state)
print "Get some vehicle attribute values:"
print " GPS: %s" % vehicle.gps_0
print vehicle.battery.level==None;
print " Last Heartbeat: %s" % vehicle.last_heartbeat
print " Is Armable?: %s" % vehicle.is_armable
print " System status: %s" % vehicle.system_status.state
print " Mode: %s" % vehicle.mode.name    # settable

print "Attitude : %s" % vehicle.attitude




# Close vehicle object before exiting script
vehicle.close()

# Shut down simulator
#sitl.stop()
print("Completed")