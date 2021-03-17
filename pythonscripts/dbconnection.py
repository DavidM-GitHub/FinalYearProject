import mysql.connector

db = mysql.connector.connect(user='root', password='root',
                                host='localhost',
                                database='fyp')
                                
flightcreated=False;
mycursor = db.cursor();

#VALIDATE IF REAL GPS 
def get2coordinates():
                        
    
    

    #mycursor.execute("ALTER TABLE droneflight MODIFY id int NOT NULL AUTO_INCREMENT;")
#mycursor.execute("INSERT INTO droneflight(currentLongitude,currentLatitude,altitude, batteryPercentage,duration,numWaypoints)" \
    #"Values(1.5,5.5,'2 metres',98,'2:40',2)");
    #waypoints=2;
    #default=0;

    #mycursor.execute("INSERT INTO droneflight(currentLongitude,currentLatitude,altitude, batteryPercentage,duration,numWaypoints)" \
    #"Values(%s,%s,%s,%s,%s,%s)",(default,default,default,default,default,waypoints));
    
    #if mycursor.lastrowid:
        #print('last insert id', mycursor.lastrowid)
        #flightid=mycursor.lastrowid
       # print(type(flightid));
    #else:
        #print('last insert id not found')

    #lon = "10.1";
    #lat="4.4";
    #alt="5 metres";
    #battery="90";
    #query=""" UPDATE droneflight SET altitude= %s WHERE id = %d """
    #data=("5 metres",flightid)
    #mycursor.execute("UPDATE droneflight SET currentLongitude = %s, currentLatitude= %s, altitude= %s, batteryPercentage= %s WHERE id = %s ",(lon,lat,alt,battery,flightid))

    #duration="4.4";
    #mycursor.execute("UPDATE droneflight SET duration= %s WHERE id = %s ",(duration,flightid))
    
    

    #mycursor.execute(query,data)
    
    
    
    #mycursor.execute("SELECT id,longitude, latitude FROM productorder WHERE orderstatus='ordered'")
    mycursor.execute("SELECT id,longitude, latitude FROM productorder WHERE orderstatus='ordered'")


    coordinates = mycursor.fetchmany(3);

    return coordinates;
#coordinates=mycursor.fetchall();


#for x in myresult:
 # print(x)
    
coordinates=get2coordinates();

points=[3];
i=0;
ids=list();
point={};
for row in coordinates:
                print("ID: ",row[0])
                print("Longitude: ", row[1])
                print("Latitude: ", row[2])
                point[i]=[row[1],row[2]]
                #mycursor.execute("UPDATE productorder SET orderstatus= %s WHERE id = %s ",("in transit",row[0]))
                ids.append(row[0]);
                i+=1
                print("\n")

for p in point:
    print("Int",point[p][0]);
    print("Int",point[p][1]);


print(point[0]);

#for id in ids:
 #   print(id)
  #  mycursor.execute("UPDATE productorder SET orderstatus= %s WHERE id = %s ",("delivered",id))
#print(point)
#print(point[1][1])
#print(point[1][0])
#print(53.503310," == ",point[1][0])
#print(type(53.503310));
#print(float(point[1][0]))
db.close()