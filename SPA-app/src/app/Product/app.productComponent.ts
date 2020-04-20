import {Component, Inject} from '@angular/core';
import { ProductService } from './app.productService';
import {Product} from '../Product/app.product';
import { stringify } from 'querystring';
import { DataService } from '../Data/app.dataService';

@Component({
    selector: 'product-root',
    templateUrl: 'app.productComponent.html',
    providers: [ProductService]

})

export class AppProductComponent{
    constructor(private productService: ProductService,private dataService: DataService){}

        public product: Product;

    ngOnInit(id: string){
        this.productService.getProduct(this.dataService.product.id).subscribe(
            response => {
                this.product = response;
                console.log(response);
            },
            error => console.log('Error al solicitar el producto')
            );
    }
}
