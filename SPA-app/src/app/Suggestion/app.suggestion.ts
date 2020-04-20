import {Inject, Injectable, Optional} from '@angular/core';

@Injectable()
export class Suggestion{

    public id: number;
    public name: string;
    public lastname: string;
    public email: string;
    public message: string;



    constructor(@Inject(String) name: string, @Inject(String) lastname: string, @Inject(String) email: string, @Inject(String) message: string){
        this.id = -1;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.message = message;
    }

}
