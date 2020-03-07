# PartyDetailsService
Party Details Service is a CRUD Service. User(Client) can use the service to /POST new clients, get clients by client ID, or get clients by specific criteria like region, status, type

#Setting up execution environment

# Resource modelling
Resources form the nucleus of any REST API design. Resource identifiers (URI), Resource representations, API operations 
(using various HTTP methods), etc. are all built around the concept of Resources 
It is very important to select the right resources and model the resources at the right granularity while designing the 
REST API so that the API consumers get the desired functionality from the APIs, the APIs behave correctly and the APIs are maintainable.

The resource modeling details for PartyDetailsService are hereunder: 

Resource Identifier(URI):- /parties
Collection Resource: /parties
Singleton Resource: /parties/{partyID}
SubCollection Resource: /parties/{partyID}/address
Singleton Resource inside Sub-Collection: /parties/{partyID}/address/{addressID}

## Examples
To insert (create) a new party in the system, we might use:
POST http://www.websitename.com/parties

To read a party with Party ID# 33245:
GET http://www.websitename.com/parties/33245 The same URI would be used for PUT and DELETE, to update and delete, respectively.

Here are proposed URIs for address:
POST http://www.websitename.com/parties/{partyID}/address for adding a new address.

GET http://www.websitename.com/parties/{partyID}/address
List of addresses that the party with PartyID has created or owns


#Release Notes