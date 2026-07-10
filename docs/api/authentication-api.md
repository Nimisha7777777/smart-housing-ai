# Authentication Service API

## Base URL

/api/auth

---

## JWT Payload

{
   userId,
   role,
   societyId
}

## Register Society

POST /register-society

{
   "societyName":"Green Valley",
   "address":"Pune",
   "city":"Pune",
   "adminFirstName":"Nimisha",
   "adminLastName":"Ghadge",
   "email":"admin@test.com",
   "password":"******",
   "phone":"9999999999"
}

## Create User

POST /users

Description:
Creates a new Resident or Guard account.

Authorization

ADMIN

Request

{
    "firstName": "",
    "lastName": "",
    "email": "",
    "phone": "",
    "building": "A",
    "unitNumber": "101",
    "role": "RESIDENT"
}

Response

201 Created

{
    "message": "User created successfully"
}

---

## Login

POST /login

Request

{
    "email": "",
    "password": ""
}

Response

200 OK

{
    "token": "",
    "user": {
        "id": 1,
        "firstName": "",
        "role": "ADMIN"
    }
}

---

## Get Profile

GET /me

Authorization: Bearer Token

Response

{
    "id": 1,
    "firstName": "",
    "lastName": "",
    "email": "",
    "role": "ADMIN"
}

---

## Update Profile

PUT /me

Authorization Required

---

## Change Password

PUT /change-password

Authorization Required

---

## Logout

POST /logout

---

## Activate Account

POST /activate-account

Description

Allows a newly created user to set their password and activate their account.

Request

{
    "activationToken":"",
    "password":""
}

---

## Forgot Password

POST /forgot-password

---

## Reset Password

POST /reset-password