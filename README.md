# sensor-data-bridge
Bridge software for receiving airborne particulate matter data from TheThingsNetwork
and forwarding it to sensor.community, opensense, cayenne.mydevices.com

Several data encodings are possible, currently supported:
* Cayenne encoding, PM is encoded as analog data, PM10 in channel 1, PM2.5 in channel 2, PM4.0 in channel 4 and PM1.0 in channel 0.
* JSON encoding, the configuration file specifies how JSON fields map to measurement properties
* SPS30 encoding, a custom encoding for SPS30 sensors, includes the particle count

Experimental support for Helium LoRaWAN, NB-IOT. Possible future support for Sigfox.

Application example config file (YAML):

~~~~
---
ttn:
  mqtt_url: "tcp://eu1.cloud.thethings.network"
  identity_server_url: "https://eu1.cloud.thethings.network"
  identity_server_timeout: 30
  apps:
  - name: "particulatematter"
    key: "secret"
    decoder:
      encoding: "CAYENNE"
      properties: ""
  - name: "ttn-hittestress"
    key: "secret"
    decoder:
      encoding: "JSON"
      properties:
      - path: "/pm10"
        item: "PM10"
      - path: "/pm2p5"
        item: "PM2_5"
      - path: "/rh"
        item: "HUMI"
      - path: "/temp"
        item: "TEMP"
  - name: "ttn-soundkit"
    key: "secret"
    decoder:
      encoding: "JSON"
      properties:
      - path: "/la/min"
        item: "NOISE_LA_MIN"
      - path: "/la/avg"
        item: "NOISE_LA_EQ"
      - path: "/la/max"
        item: "NOISE_LA_MAX"
nbiot:
  port: 9000
senscom:
  url: "https://api.sensor.community"
  timeout: 30
opensense:
  url: "https://api.opensensemap.org"
  timeout: 30
mydevices:
  url: "https://api.mydevices.com"
  timeout: 30
geolocation:
  url: "https://location.services.mozilla.com"
  timeout: 30
  apikey: "test"
~~~~
