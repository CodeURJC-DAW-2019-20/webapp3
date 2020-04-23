import {Inject, Injectable, Optional} from '@angular/core';
import {Sort} from './app.Sort';

@Injectable()
export class Pageable{
    sort:Sort;
    offset:number;
    pageSize:number;
    pageNumber:number;
    paged:boolean;
    unpaged:boolean;
}
   /* 
    
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

