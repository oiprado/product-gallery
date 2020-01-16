import { NgModule } from '@angular/core';
import { ProductService } from './product.service';
import { CategoryService } from './category.service'
 
@NgModule({
    declarations: [
    ],
    exports: [
    ]
    ,
    imports: [
      
    ],
    providers: [ ProductService, CategoryService ]
  })
  export class ServicesModule { }