
import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../../services/category.service';
import { AdminProductService } from '../../services/admin-product.service';
import { TokenService } from '../../services/token.service';
import Swal from 'sweetalert2'
import { Product } from '../../model/product.model';
import { Router} from '@angular/router';

@Component({
  selector: 'header-section',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  categories;
  model: any;

  constructor(
    private _CategoryService: CategoryService, 
    private _TokenService: TokenService, 
    private _Router: Router) { 
    this.model = {
      username: "",
      password: "",
      grant_type: "password"

    }
  }

  ngOnInit(): void {

    this._Router.routeReuseStrategy.shouldReuseRoute = () => false;

    this._CategoryService.getCategoryList().subscribe((response: any) => {
      this.categories = response;
    });
  }

  navigate(categoryId: number) {
    sessionStorage.setItem("category", categoryId.toString());
    this._Router.navigate(['/list']);
  }

  login() {
    let credential = {
      username: this.model.username,
      password: this.model.password,
      grant_type: "password"
    };
    this._TokenService.token(credential).subscribe((response: any) => {
      this._TokenService.authenticated = true;
      sessionStorage.setItem("access_token", response.access_token);
    }, error => {
      Swal.fire({
        title: 'Error!',
        text: 'Login and password incorrect!!',
        icon: 'error',
        confirmButtonText: 'Try again!!'
      })
    });
  }

  logout() {
    this._TokenService.authenticated = false;
    this.model.password = "";
    sessionStorage.setItem("access_token", null);
    this._Router.navigate(['/list'], { queryParams: { page: 0, size:10, sort: "name", direction: "asc"} });
  }

  
}