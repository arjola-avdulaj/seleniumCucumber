Feature: Nop Commerce Page Test

  Background:
  Given the page 'https://demo.nopcommerce.com/' is opened

  @Demo
  Scenario: Register User
    Then click 'Log in' menu from home page
    Then click 'Register' button
    Then select 'Female' in 'Gender:' input field
    Then type 'Arjola' in the 'First name:' input field
    Then type 'Avdulaj' in the 'Last name:' input field
    Then select "2" from 'Day' dropdown
    Then select "January" from 'Month' dropdown
    Then select "2002" from 'Year' dropdown
    Then type 'arjolaavdulaj1@gmail.com' in the 'Email:' input field
    Then type 'Lufthansa Industry Solutions' in the 'Company name:' input field
    Then type 'arjola123' in the 'Password:' input field
    Then type 'arjola123' in the 'Confirm password:' input field
    Then click 'Register User' button
    Then check the text 'Your registration completed' is shown
    Then click 'Log out' button

  @Demo
  Scenario: Login User
    Then click 'Log in' menu from home page
    Then type 'arjolaavdulaj1@gmail.com' in the 'Email:' input field
    Then type 'arjola123' in the 'Password:' input field
    Then click 'Log in' button
    Then check the text 'Welcome to our store' is shown in log in page
    Then check 'Log out' is displayed
    Then click 'Log out' button


  @Demo
  Scenario: My account test
    Then click 'My account' button in my account
    Then check 'Female' is typed in 'Gender' input field
    Then check 'Arjola' is typed in 'First name' input field
    Then check 'Avdulaj' is typed in 'Last name' input field
    Then check "2" is typed in 'Day' input field
    Then check "1" is typed in 'Month' input field
    Then check "2002" is typed in 'Year' input field
    Then check 'arjolaavdulaj1@gmail.com' is typed in 'Email' input field
    Then check 'Lufthansa Industry Solutions' is typed in 'Company' input field
    Then click 'Log out' button

  #@Demo
  Scenario: Dashboard Test
    Then hover over 'Computers' menu
    Then click 'Notebooks' in main page
    Then check the text 'Notebooks' is shown
    Then choose 'nine' on display dropdown
    Then check '6' items are displayed
    Then select '16' on filter attributes
    Then check '1' items are displayed
    Then select '16' on filter attributes
    Then check '6' items are displayed
    Then add item '2' to 'wish' list
    Then check the 'wishlist' notification 'The product has been added to your wishlist' is displayed
    Then add item '3' to 'wish' list
    Then check the 'wishlist' notification 'The product has been added to your wishlist' is displayed
    Then add item '4' to 'cart' list
    Then check the 'cartlist' notification 'The product has been added to your shopping cart' is displayed
    Then add item '5' to 'cart' list
    Then check the 'cartlist' notification 'The product has been added to your shopping cart' is displayed
    Then add item '6' to 'cart' list
    Then check the 'cartlist' notification 'The product has been added to your shopping cart' is displayed
    Then check that 'wishlist' on menu bar displays "(2)"
    Then check that 'cartlist' on menu bar displays "(3)"

  #@Demo
  Scenario: Shopping Cart Test
    Then hover over 'Shopping cart' menu
    Then check 'Go to cart' is displayed
    Then click 'Go to cart' in main page
    Then check the text 'Shopping cart' is shown
    Then check that the following links are shown
    | Update shopping cart | Continue shopping | Estimate shipping |
    Then verify that the prices sum is equal to Total Price in the end of the page

  #@Demo
  Scenario: Empty Shopping Cart
    Then empty shopping cart
    Then verify shopping cart is empty