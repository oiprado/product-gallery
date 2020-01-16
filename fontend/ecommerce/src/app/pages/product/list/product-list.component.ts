
import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ProductService } from 'src/app/shared/services/product.service';
import { ActivatedRoute } from '@angular/router';
import { ProductPageable } from 'src/app/shared/model/product-pageable.model';

@Component({
    selector: 'product-list',
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css']
})
export class ProductListComponent  {
    ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
        console.log("somethig change")
    }

    constructor(private _ProductService: ProductService, private _ActivatedRoute: ActivatedRoute) {
        
     }

    products: any;

    ngOnInit(): void {

        let params: ProductPageable;
        
        this._ActivatedRoute.queryParams.subscribe((response: ProductPageable) => {
            params = response;
        });
        this.query(params);        
    }

    cleanFilter() {
        let params: ProductPageable;
        params = { page: 0, size:10, sort: "name", direction: "asc"};
        this.query(params);
    }

    private query(params: ProductPageable): void {
        this._ProductService.getProductList(params).subscribe((response: any) => {
            this.products = response;
        });
    }

}