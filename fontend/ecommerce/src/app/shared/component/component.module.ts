import { NgModule } from '@angular/core';
import { CategoryComponent } from './category/category.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
 
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
      CommonModule,
      FormsModule,
      RouterModule
    ],
    providers: []
  })
  export class ComponentModule { }