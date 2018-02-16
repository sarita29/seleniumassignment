Feature: Book flight tickets
 Scenario: Book one way ticket in cleartrip
     Given user open browser and application
     Then user verify search flight page
     When user click on "One Way" button
     When user fill form "Pune" and to "Mumbai" detail
     When user select "depart on" date "Fri, 31 Aug, 2018" 
     When user click on "Search" button
     Then user verify the searched flight
     
 Scenario: Book round trip ticket in cleartrip
     Given user open browser and application
     Then user verify search flight page
     When user click on "Round Trip" button
     When user fill form "Pune" and to "Mumbai" detail
     When user select "depart on" date "Fri, 31 Aug, 2018" 
     When user select "return" date "Mon, 3 Sep, 2018" 
     When user click on "Search" button
     Then user verify the searched flight     