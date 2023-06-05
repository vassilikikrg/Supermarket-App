// Initialize and add the map
let map;

async function initMap() {
    // The location of Uluru
    const position = { lat: 37.974562, lng: 23.735637 };
    // Request needed libraries.
    //@ts-ignore
    const { Map } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");

    // The map, centered at Uluru
     map = new Map(document.getElementById("map"), {
        zoom: 8,
        center: position,
        mapId: "DEMO_MAP_ID",
    });

    navigator.geolocation.getCurrentPosition(function(position) {
        // Center on user's current location if geolocation prompt allowed
        var initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
        map.setCenter(initialLocation);
        map.setZoom(13);
    }, function(positionError) {
        // User denied geolocation prompt - default to Athens
        map.setCenter(new google.maps.LatLng(37.974562, 23.735637));
        map.setZoom(8);
    });

    // The marker, positioned at Uluru
    const marker = new AdvancedMarkerElement({
        map: map,
        position: position,
        title: "Uluru",
    });
}

initMap();