# Rewardsprogram
Webservice generate using spring boot to calculate customer rewards

## Usage
Application is a webservice and has following main URLs:

#### GET /rewards

Shows list of all customer with their monthly and total rewards.

#### GET /rewards/{cusotmerId}
Shows monthly and weekly rewards for specified cusotmer ID.

#### GET /rewards/transactions
List all the transactions in database


#### Test cases
Test cases are at /rewardsprogram/src/test/java/com/assessment/retailer/rewardsprogram/RewardsprogramApplicationTests.java
