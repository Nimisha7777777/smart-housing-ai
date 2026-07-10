# Payment Service API

## Base URL

/api/payments

---

## Create Razorpay Order

POST /create-order

Authorization

RESIDENT

---

## Verify Payment

POST /verify

Authorization

RESIDENT

---

## Download Receipt

GET /receipt/{paymentId}

Authorization

RESIDENT

-Only returns data belonging to the authenticated society.

---

## Payment History

GET /history

Authorization

RESIDENT

-Only returns data belonging to the authenticated society.

---

## Admin Payment Report

GET /report

Authorization

ADMIN

-Only returns data belonging to the authenticated society.

---

## Razorpay Webhook

POST /webhook

Description

Receives payment confirmation from Razorpay and updates payment status.