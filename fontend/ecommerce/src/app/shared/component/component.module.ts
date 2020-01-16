import { NgModule } from '@angular/core';
import { CategoryComponent } from './category/category.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { CommonModule } from '@angular/common';
 
@NgModule({
    declarations: [
      CategoryComponent,
      FooterComponent,
      HeaderComponent
    ],
    exports: [
        CategoryComponent,
        FooterComponent,
        HeaderComponent
    ]
    ,
    imports: [
      CommonModule
    ],
    providers: []
  })
  export class ComponentModule { }