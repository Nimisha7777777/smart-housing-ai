# Smart Housing AI - System Design

## Architecture

                    React Frontend
                           │
                    API Gateway
                           │
        JWT contains(userId, role, societyId)
                           │
 ┌──────────┬────────────┬────────────┬────────────┬──────────┐
 │          │            │            │            │
 ▼          ▼            ▼            ▼            ▼
Auth   Maintenance    Payment     Visitor     Parking
 │          │            │            │            │
 ▼          ▼            ▼            ▼            ▼
MySQL     MySQL       MySQL      MongoDB      MySQL

AI Service
    |
Calls APIs of all services

Payment Gateway
    |
Razorpay


## Multi-Tenant Architecture

The Smart Housing AI platform follows a multi-tenant architecture.

A single deployment of the application can serve multiple housing societies.

Each society has its own administrators, residents, guards, maintenance records, parking allocations, visitor records, and payments.

Data isolation is achieved using a unique `societyId` stored in every business entity.

The authenticated user's JWT contains the `societyId`, allowing every service to restrict access to data belonging only to that society.

## Platform Roles

The platform supports four roles.

- SUPER_ADMIN
- ADMIN
- GUARD
- RESIDENT

SUPER_ADMIN manages the platform and registered societies.

ADMIN manages a single society.

GUARD manages visitor entry and exit.

RESIDENT accesses maintenance, parking, visitors, and AI features.