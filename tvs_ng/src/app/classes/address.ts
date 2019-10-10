export class Address {

    //  to hold collected latitude and longitue
    constructor(lat: number, lng: number) {
        this.lat = lat
    }

    public lat: number
    public lng: number
    public results: number[]

    // Return a small array for lat/lng
    public getAdr() {
        this.results[0] = this.lat
        this.results[1] = this.lng
        return this.results
    }
}