import { Injectable } from "@angular/core";
import { SimpleRest, Resource, Method } from 'ngx-simple-rest';
import { Product } from "../model/product.model";

@Resource(
  {
    host: "http://localhost:8081/com.perfiltic.oiprado.developer/",
    basePath: "/admin/product-managment",
    useToken: true
  }
)
@Injectable()
export class AdminProductService extends SimpleRest<any>{

  @Method({
    name: "",
    type: "post",
    headers: [
      { name: "Content-Type", value: "application/json" },
      { name: "Accept", value: "application/json" }
    ]
  })
  create(product: Product) {
    return this.invokeResource(this, product);
  }

}