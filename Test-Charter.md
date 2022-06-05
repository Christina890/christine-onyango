## Monefy App Test Charter

#### Test Device

Samsung S20

#### OS Version

Android 12

#### Application Under test

Monefy Android Application
Version 1.16.0 with basic access and no subscription

#### Objectives of testing

- To verify critical functionality that enable users to add income, expenses and manage transactions
- To Verify the installation process
- To verify usability of the application

### Charter 001 - Application Installation

#### Time allocated

20 Minutes

#### Priority

High

#### Coverage

| #   | Feature                                       | Expected result                                                                |
| --- | --------------------------------------------- | ------------------------------------------------------------------------------ |
| 1   | Install the Monefy application from PlayStore | Application is installed successfully                                          |
| 2   | Open the installed application                | The application is opened successfully and user navigated to the launch screen |

#### Bugs

No bugs discovered

#### Recommendation

None

### Charter 002 - Application Launch Screens

#### Time allocated

20 Minutes

#### Priority

Medium

#### Coverage

| #   | Feature                             | Expected result                                     |
| --- | ----------------------------------- | --------------------------------------------------- |
| 1   | Navigate through the launch screens | User is able to navigate from one screen to another |
| 2   | Verify correctness of the content   | Some gramatical errors in the text                  |

#### Bugs

Control your "Spend" and start saving should read control your "spending" and start saving

#### Recommendation

User should be allowed to swipe the screens instead of using buttons. User should be allowed to swipe back to the previous screen if need be
Most common settings like currency and language selection should be included as part of the set up screens

### Charter 003 - Dashboard/Landing Screen

#### Time allocated

20 Minutes

#### Priority

High

#### Coverage

| #   | Feature                                   | Expected result                                                                      |
| --- | ----------------------------------------- | ------------------------------------------------------------------------------------ |
| 1   | Verify the look and feel of the dashboard | Tips displayed on the dashboard should be dismissed automatically after a given time |

#### Bugs

Tooltips should automatically close when a user navigates to a different screen or after a few seconds
Tooltips look like warnings as opposed to suggestions/tips

### Charter 004 - Add Expenditure

#### Time allocated

20 Minutes

#### Priority

High

#### Coverage

| #   | Feature             | Expected result                                                                    |
| --- | ------------------- | ---------------------------------------------------------------------------------- |
| 1   | Add expenditure     | User should be able to add an expenditure and label it accordingly                 |
| 2   | Balance update      | Adding an expenditure should update the balance accordingly                        |
| 3   | Expenditure tagging | Any expenditure added should be tagged to the correct category on the dashboard    |
| 4   | List expenditure    | Any expenditure added should be added to the list of transactions for the user     |
| 5   | Select Account      | User should be able to select the account for which they are adding an expenditure |

#### Bugs

Tooltips should automatically close when a user navigates to a different screen or after a few seconds

### Charter 005 - Add Income

#### Priority

High

#### Time allocated

20 Minutes

#### Coverage

| #   | Feature        | Expected result                                                                    |
| --- | -------------- | ---------------------------------------------------------------------------------- |
| 1   | Add income     | User should be able to add an income and label it accordingly                      |
| 2   | Balance update | Adding an income should update the balance accordingly                             |
| 3   | List income    | Any expenditure added should be added to the list of transactions for the user     |
| 4   | Select Account | User should be able to select the account for which they are adding an expenditure |

#### Bugs

### Charter 005 - Edit an existing transaction

#### Time allocated

30 Minutes

#### Priority

High

#### Coverage

| #   | Feature             | Expected result                                                                    |
| --- | ------------------- | ---------------------------------------------------------------------------------- |
| 1   | Edit income/Expense | User should be able to edit income/expense                                         |
| 2   | Balance update      | Editing the transaction amount should update the balance accordingly               |
| 3   | Select Account      | User should be able to select the account for which they are adding an expenditure |

#### Bugs

Same Keyboard (Native keyboard), should be used to edit both amount and notes
If a user exits the edit screen before completing, the balance is updated without a user explicitly choosing to save the typed balance.
A user should be able to edit any digit without necessarily deleting the whole amount.

### Charter 006 - Initiating a transfer

#### Time allocated

45 Minutes

#### Priority

High

#### Coverage

| #   | Feature                               | Expected result                                               |
| --- | ------------------------------------- | ------------------------------------------------------------- |
| 1   | Initiate a transfer                   | User should be able to initiate a trasnfer                    |
| 2   | Balance update                        | Balance should be updated on successful transfers             |
| 3   | Transfer success/failure notification | Users should be notified of successful/unsuccessful transfers |

#### Bugs

The button to confirm the tranfer should be separated from the keyboard.
Balance should automatically updated after a transfer. To replicate, initiate a transfer when the balance of the initiating account is zero
A preview of the balance should be included in the account selection screen to allow users make informed decisions

## Other Features to be tested

- Search
- Features offered on subscription
- Create Data Back up
- Restore data
- Filters by Day/Week/Month etc
- Cross Platform Testing
