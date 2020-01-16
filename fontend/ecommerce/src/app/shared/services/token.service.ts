import { Injectable } from '@angular/core';
import { SimpleRest, Method, Resource } from 'ngx-simple-rest';
import { ProductPageable } from "../model/product-pageable.model"
import { Observable } from 'rxjs';
import { Token } from '../model/token.model';

@Injectable()
@Resource(
  {
    host: "http://localhost:8081/com.perfiltic.oiprado.developer",
    basePath: "/oauth"
  }
)
export class TokenService extends SimpleRest<Token> {

  authenticated: boolean = false;

  @Method({
    name: "/token",
    type: "post",
    requestParams: true,
    headers: [
      { name: "Content-Type", value: "application/json" },
      { name: "Accept", value: "application/json" },
      { name: "Authorization", value: "Basic c3ByaW5nLXNlY3VyaXR5LW9hdXRoMi1yZWFkLXdyaXRlLWNsaWVudDpzcHJpbmctc2VjdXJpdHktb2F1dGgyLXJlYWQtd3JpdGUtY2xpZW50LXBhc3N3b3JkMTIzNA==" }
    ]
  })
  public token(credential) {
    console.log(credential)
    return this.invokeResource(this, credential);
  }

  public closeSession() {
    this.authenticated = true;
  }

}