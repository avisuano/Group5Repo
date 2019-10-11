export class Forum{

    /*
     * Creating a constructor for the forum class.
     */
    constructor(forum_id:number, title:string, body:string, isOffensive:boolean,
        replies:number, user_id:number){
        this.forum_id = 0;
        this.title = title;
        this.body = body;
        this.isOffensive = false;
        this.replies = replies;
        this.user_id = user_id;
    }

    /**
     * Declaring variables
     */
    public forum_id:number = 0;
    public title:string;
    public body:string;
    public isOffensive:boolean;
    public replies:number;
    public user_id:number;

    /**
     * Get Id
     */
    public getId(forum_id:any, title:string){return this.forum_id;}
}