   Feature: Add to cart

  #Scenario: Add apple iphone mobile to cart
    #Given user open browser and application
    #Then user verify homepage
    #When user click on "Apple" under "Electronics" tab
    #Then verify user landed on "Apple" page
    #When user click on "iPhone" tab
    #When user select "Apple iPhone" product
    #Then user verify product description page

    Scenario: Add apple mobile to cart
    Given user open browser and application
    Then user verify homepage
    When user click on "modelName" under "category" tab
    #Then verify user landed on "modelName" page
    #When user select "modelName" product
    #Then user verify product description page
   
    #Examples: 
      #| modelName | category    | 
      #| Samsung   | Electronics | 
      #| OPPO      | Electronics | 
      
