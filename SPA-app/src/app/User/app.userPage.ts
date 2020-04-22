import {Inject, Injectable, Optional} from '@angular/core';
import {User} from './app.User';
import {Pageable} from '../Pageable/app.pageable'
import { Sort } from '../Pageable/app.Sort';

@Injectable()
export class UserPage{
    userList: User[]
    pageable: Pageable;
    totalPages:number;
    totalElements:number;
    last:boolean;
    size:number;
    number:number;
    sort:Sort;
    numberOfElements:number;
    first:boolean;
    empty:boolean;
}


    /*
    userList[],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 5,
        "pageSize": 5,
        "pageNumber": 1,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 2,
    "totalElements": 9,
    "last": true,
    "size": 5,
    "number": 1,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 4,
    "first": false,
    "empty": false

*/
