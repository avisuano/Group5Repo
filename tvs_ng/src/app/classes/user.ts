export class User {
    /*
     * Creating a constructor for the forum class.
     */
    constructor(user_id:number, firstname:string, lastname:string, username:string,
        password:string, email:string, street_address:string, country:string,
        state:string, zip:number, isAdmin:boolean, isOffensiveCounter:number){
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.street_address = street_address;
        this.country = country;
        this.state = state;
        this.zip = zip;
        this.isAdmin = isAdmin;
        this.isOffensiveCounter;
    }

    /**
     * Declaring variables
     */
    public user_id:number = 0;
    public firstname:string;
    public lastname:string;
    public username:string;
    public password:string;
    public email:string;
    public street_address:string;
    public country:string;
    public state:string;
    public zip:number;
    public isAdmin:boolean;
    public isOffensiveCounter:number;

    /**
     * Get Id
     */
    public getId(
        user_id:any, 
        firstname:string,
        username:string, 
        password:string,
        email:string,
        street_address:string,
        country:string,
        state:string,
        zip:number,
        isAdmin:boolean,
        isOffensive:boolean){return this.user_id;}
}
