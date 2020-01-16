import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentModule } from './shared/component/component.module';
import { CommonModule } from '@angular/common';

import { ServicesModule } from "./shared/services/services.module"
import { ProductListComponent } from './pages/product/list/product-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductCreateComponent } from './pages/product/create/product-create.component';
import { DefaultComponent } from './pages/default/defaul.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCreateComponent,
    DefaultComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    RouterModule,
    CommonModule,
    ReactiveFormsModule,
    AppRoutingModule,
    CommonModule,
    ComponentModule,
    ServicesModule
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
