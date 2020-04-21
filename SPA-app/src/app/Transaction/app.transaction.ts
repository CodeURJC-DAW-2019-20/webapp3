import {Inject, Injectable, Optional} from '@angular/core';

@Injectable()
export class Transaction{



    constructor(@Inject(String) name: string, @Inject(String) passwordHash: string, @Inject(String) lastname: string, @Inject(String) email: string, @Inject(String) address: string, @Inject(String) city: string, @Inject(String) country: string, @Inject(String) cp: string, @Inject(String) phone: string){

    }

}
