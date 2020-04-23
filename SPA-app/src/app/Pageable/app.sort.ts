import {Inject, Injectable, Optional} from '@angular/core';


@Injectable()
export class Sort{
    sorted:boolean;
    unsorted:boolean;
    empty:boolean;
}
/*
"sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
    */