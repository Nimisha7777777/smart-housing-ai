# Maintenance Service API

## Base URL

/api/maintenance

---

## Generate Monthly Maintenance

POST /generate

Description

Generates maintenance bills for all residents.

Authorization

ADMIN

Response

201 Created

{
    "message":"Maintenance generated successfully."
}

---

## Get Current Maintenance

GET /current

Authorization

RESIDENT

Response

{
    "maintenanceId":1,
    "month":"July",
    "year":2026,
    "amount":3500,
    "status":"PENDING",
    "dueDate":"2026-07-10"
}

-Returns maintenance belonging to the authenticated user's society.
---

## Get Maintenance History

GET /history

Authorization

RESIDENT

Response

[
   {
      "month":"June",
      "amount":3500,
      "status":"PAID"
   },
   {
      "month":"May",
      "amount":3500,
      "status":"PAID"
   }
]

-Returns maintenance belonging to the authenticated user's society.

---

## Get Pending Residents

GET /pending

Authorization

ADMIN

Response

[
   {
      "residentName":"Nimisha",
      "flat":"A101",
      "amount":3500
   }
]

-Returns maintenance belonging to the authenticated user's society.

---

## Update Due Date

PUT /due-date

Authorization

ADMIN

---

## Get Maintenance By Resident

GET /search

Authorization

ADMIN

Authorization

ADMIN

Query Parameters

flat

status

month

year