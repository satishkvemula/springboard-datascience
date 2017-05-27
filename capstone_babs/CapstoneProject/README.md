## Capstone Project Proposal

1. **What is the problem you want to solve?**
With Bike share program, there is no guarantee that the bike that is rented at a specific station would return back to the same station. Also, there is no guarantee that as many number of bikes that leave a station would return back, as the number of bikes that leave a particular station. That means, there will be some stations, that rent out more bikes than they receive back, and vice versa, there will be some stations that receive more bikes than they rent out. This has a clear bearing on the number of terminals available in each station. The stations which receive surplus bikes should have additional vacant terminals to accommodate the extra bikes. Also, planning needs to be done to replenish the bikes at the stations which have deficit.

By looking at the trip data and the station data available, I would like to develop a model which reasoably predicts the bike surplus/deficit situation for a station on a given day.

2. **Who is your client and why do they care about this problem? In other words, what will your client DO or DECIDE based on your analysis that they wouldn’t have otherwise?**

BABS would be the client that would be most concerned, as it could have a major effect on the customer perception. If a customer does not find a bike available at a port, or if he does not find an avaiable terminal/port to leave the bike back, either way, the customer would be dissatisfied, and possibly think twice before renking a bike out. BABS has to plan for replenishing the bikes from surplus stations to deficit ones on daily basis. My analysis in the Capstone project can help BABS to proactively plan the most efficient way to move the bikes around. If we can integrate the geographical layout of the stations involved, we can also reduce the number of truck rolls that have to happen to adjust the bike availabiity at each stations

3. **What data are you going to use for this? How will you acquire this data?**
The main source of data is the BABS open sourced-data files which have 
..*the station information with their geographic location and available number of terminals.
..*the trip information with each single trip, with its starttime/endtime, startstation/endstation with the subscriber zipcode information when available
The data files provide data collected over a period of 1 year

I am plannig to augment this data with the google maps api to tie the geographical insights using the data available in above files.

4. **In brief, outline your approach to solving this problem (knowing that this might change later).**
The approach I would like to take is to derive the data surrounding the stations
..* When a bike is leaving the station
..* When a bike is returned to the station
..* Derive the net bike count change per minute, per 10 minutes, per hour and per day

Once this data is derived, I can build a statistial model using that data, and can use it to predict the bike usage patterns at a station at hourly and daily intervals

5. **What are your deliverables? Typically, this would include code, along with a paper and/or a slide deck.**
..* The code which does the statistical analysis
..* Paper outlining the findings and insights gained
..* Slide deck to present findings 
