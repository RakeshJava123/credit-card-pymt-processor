This is the spring boot project which demonstrate the reward points for every spending(transaction).

This service has 6 different endpoints which can be used for different purposes.

Create endpoint api for profile/customer: It will create the customer profile
curl -X POST "http://localhost:8081/profile/create" -H "accept: application/json" -H "Content-Type: application/json" -d "{\t\"acctName\": \"rakesh\",\t\"acctNum\": \"1234\",\t\"creditCardNum\": \"1234\",\t\"creditLimit\": 1000,\t\"availableCreditLimit\": 1000,\t\"rewardPointsEarned \": 0}"

Create endpoint api for transaction: It will create the transaction.
curl -X POST "http://localhost:8081/transaction/create" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"amountSpent\": 60, \"profile\": { \"profileId\": 1, \"rewardPointsEarned\": 0 }, \"transactionDate\": \"2021-08-01T05:14:34.036Z\", \"transactionId\": 0}"

Get endpoint api:
http://localhost:8081/transaction/last/threemonth/all

This endpoint will be calculated the last three month transaction's reward points. Which uses the below mention logic: 

1. A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

2. Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

Response:
[
  {
    "profileId": 1,
    "acctName": "rakesh",
    "acctNum": "1234",
    "creditCardNum": "1234",
    "creditLimit": 1000,
    "availableCreditLimit": 685,
    "rewardPointsEarned": 70,
    "transactions": [
      {
        "transactionId": 2,
        "amountSpent": 10,
        "transactionDate": "2021-07-03T03:14:34.036+00:00",
        "rewardPoints": 0
      },
      {
        "transactionId": 3,
        "amountSpent": 5,
        "transactionDate": "2021-08-03T03:14:34.036+00:00",
        "rewardPoints": 0
      },
      {
        "transactionId": 4,
        "amountSpent": 120,
        "transactionDate": "2021-08-01T03:14:34.036+00:00",
        "rewardPoints": 0
      },
      {
        "transactionId": 5,
        "amountSpent": 120,
        "transactionDate": "2021-08-01T04:14:34.036+00:00",
        "rewardPoints": 90
      },
      {
        "transactionId": 6,
        "amountSpent": 60,
        "transactionDate": "2021-08-01T05:14:34.036+00:00",
        "rewardPoints": 70
      },
      {
        "transactionId": 4,
        "amountSpent": 120,
        "transactionDate": "2021-08-01T03:14:34.036+00:00",
        "rewardPoints": 0
      },
      {
        "transactionId": 5,
        "amountSpent": 120,
        "transactionDate": "2021-08-01T04:14:34.036+00:00",
        "rewardPoints": 90
      },
      {
        "transactionId": 6,
        "amountSpent": 60,
        "transactionDate": "2021-08-01T05:14:34.036+00:00",
        "rewardPoints": 70
      }
    ]
  }
]

http://localhost:8081/transaction/profileid/1/period?from=2021-07-01&to=2021-09-01

This endpoint will provide the response for the mention between dates transaction and calculate the reward points for the given customer/profile id.

Response:

{
  "profileId": 1,
  "acctName": "rakesh",
  "acctNum": "1234",
  "creditCardNum": "1234",
  "creditLimit": 1000,
  "availableCreditLimit": 685,
  "rewardPointsEarned": 70,
  "transactions": [
    {
      "transactionId": 2,
      "amountSpent": 10,
      "transactionDate": "2021-07-03T03:14:34.036+00:00",
      "rewardPoints": 0
    },
    {
      "transactionId": 3,
      "amountSpent": 5,
      "transactionDate": "2021-08-03T03:14:34.036+00:00",
      "rewardPoints": 0
    },
    {
      "transactionId": 4,
      "amountSpent": 120,
      "transactionDate": "2021-08-01T03:14:34.036+00:00",
      "rewardPoints": 0
    },
    {
      "transactionId": 5,
      "amountSpent": 120,
      "transactionDate": "2021-08-01T04:14:34.036+00:00",
      "rewardPoints": 90
    },
    {
      "transactionId": 6,
      "amountSpent": 60,
      "transactionDate": "2021-08-01T05:14:34.036+00:00",
      "rewardPoints": 70
    }
  ]
}

