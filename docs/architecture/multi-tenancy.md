# Multi-Tenant Design

The Smart Housing AI platform supports multiple housing societies using a shared application deployment.

Each society has isolated data.

Every authenticated request contains a JWT token with:

- userId
- role
- societyId

Every service validates the token and filters records using the societyId.

No service can access another society's data.

This approach allows one deployment to securely serve multiple independent housing societies.