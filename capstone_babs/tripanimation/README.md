## Implementation notes for implementing the trip animation


### Get steps inside the first leg,
### Get the total distance in meters, we got

### Get counts of trips per route, and do the following calculation only for those routes. 
### It might be costly to do it for all combinations

### See which step this meterstone would fall in. and get the latitude and longitude by using proportional calculation based on
### how much distance in the step vs total step distance

### Write down the latitude and longitude for every 10 meters,every 20 meters, and every 50 meters

### each distance in different file, write down lat and long, also write the number of 10 meter blocks

### For each trip, guess where the user would have been every 10/20/30 seconds
### Divide duration by the number of divisions, and for each of meterstone, 
### come up with the time in seconds the rider would be at the meterstone
### Store in different file for 10/20 and 50 meter
### For 10 meter - take it to nearest 5 second interval
### For 20 meter - take it to nearest 10 second interval
### For 50 meter - take it to nearest 30 second interval

### Now consolidate by writing the time, and latitude/longitudes to file. Make sure all times are of same granularity.

### A script which picks up the latitudes and longitudes of points belonging to the same time, and plots it, and names it by the time
### and 10/20 or 50 . meter. Store the file

###Selenium driver use, to go over each page, to produce the effect of animation


Do the whole logic based on zone
-60
Separate out the trips/statios by zone
And then get top 50 routes in each

Route Mile stones - 30
StartStationId, End StationId, MilestoneCount, Milestones(lat,lng)

TripMilestones - 60
TripId, StartStationId, EndStationId, Duration, Milestone Times

Timeline of Trips - 60
Sort by time
Time, lat, long

Group by time to get group of lat longs, -60

For all those lat, longs generate the map, and name it by time
-60

Selenium project to go over each of those files, and generate jpeg


2014_SF_Top50Routes
startStationId	
 endStation

count

2014_SF_TripsInTop50Routes
Duration	Start Date	startStationId	endStationId	distance

2014_SF_TopRoute_50mtr_Milestones
startStationId endStationId distance totalMileStones Lats	 	Lngs
12			34			1343	20			(1,2,3)	(2,3,4)

Start time, duration, milestone count, 
Duration/ Milestone-count number of divisions
startTime + x * duration - Round it to nearest 20 second . 0, 20, 40

2014_SF_Trip_Milestone_times(optional startStationId, endStationId)
	TripId startTime Duration MileStoneTimes
	1234  10/20/2017 5:34	2345	(time1, time2, time3)

Now, we need 2014_SF_Trip_Milestone_times & 2014_SF_TopRoute_50mtr_Milestones to come up with following data

2014_SF_Timeline_For_TopRoutes (Sorted by time, see if there is a need to address empty slots)
Time			Lats 	Longs
10/20/2014 9:00:00	(1,2,3)	(2,3,4)
10/20/2014 9:00:10 (1,2,3)		(2,3,4)

For each of the time entries, prepare googleMap with points, and time printed on the map
Prepare Map html for each time entry(see if there is any limit on number of latitudes and longitudes to show, Time printed on map at the top. right)
SF_Top50_50mtr_20sec_Trip_Route_Map_2014_04_28_9_10_20.html
SF_Top50_50mtr_20sec_Trip_Route_Map_2014_04_28_9_10_40.html
SF_Top50_50mtr_20sec_Trip_Route_Map_2014_04_28_10_05_20.html

Use Selenium to open each html page, and take screenshot for each of the maps(See which format is friendlier to animation, jpg or png)
SF_Top50_50mtr_20sec_Trip_Route_Map_2014_04_28_9_10_20.jpeg
SF_Top50_50mtr_20sec_Trip_Route_Map_2014_04_28_9_10_40.jpeg
SF_Top50_50mtr_20sec_Trip_Route_Map_2014_04_28_10_05_20.jpeg

Animation over the PNGs..Timelapse over JPG/PNG files

SF base lat/lng for maps - 37.761710, -122.433764

