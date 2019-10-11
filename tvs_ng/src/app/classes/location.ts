export class Location{

    constructor(latitude: number, longitude:number){
        this.latitude = latitude
        this.longitude = longitude
    }

    public latitude: number
    public longitude: number
    public LatLng: any

    public getLatLng(){
        return this.LatLng
    }
}