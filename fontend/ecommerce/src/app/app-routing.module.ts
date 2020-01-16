import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { ProductListComponent } from './pages/product/list/product-list.component';
import { ProductCreateComponent } from './pages/product/create/product-create.component';
import { DefaultComponent } from './pages/default/defaul.component';


const routes: Routes = [
  { path: 'list', component: ProductListComponent, pathMatch: 'full'},
  { path: 'create-product', component: ProductCreateComponent, pathMatch: 'full'} ,
  { path: 'default', component: DefaultComponent, pathMatch: 'full'} ,
  // { path: '**', redirectTo: 'default', pathMatch: 'full' },
  { path: '', redirectTo: 'default', pathMatch: 'full' }
];

const config: ExtraOptions = {
  useHash: true,
};


@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
