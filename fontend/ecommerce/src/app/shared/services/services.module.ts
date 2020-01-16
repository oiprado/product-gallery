import { NgModule } from '@angular/core';
import { ProductService } from './product.service';
import { CategoryService } from './category.service'
import { TokenService } from './token.service'
import { AdminProductService } from './admin-product.service';
@NgModule({
    declarations: [
    ],
    exports: [
    ]
    ,
    imports: [
      
    ],
    providers: [ ProductService, CategoryService, TokenService, AdminProductService ]
  })
  export class ServicesModule { }