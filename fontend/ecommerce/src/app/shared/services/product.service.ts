import { Injectable } from '@angular/core';
import { SimpleRest, Method, Resource } from 'ngx-simple-rest';
import { ProductPageable } from "../model/product-pageable.model"
import { Observable } from 'rxjs';

@Injectable()
@Resource(
  {
    host: "http://localhost:8081/com.perfiltic.oiprado.developer",
    basePath: "/api/product-managment",
    trace: false
  }
)
export class ProductService extends SimpleRest<any> {
  
  @Method({
    name: "",
    type: "get",
    requestParams: true,
    headers: [
      { name: "Content-Type", value: "application/json" },
      { name: "Accept", value: "application/json" }
    ]
  })
  getProductList(params: ProductPageable): Observable<any> {
    return this.invokeResource(this, params);
  }

}