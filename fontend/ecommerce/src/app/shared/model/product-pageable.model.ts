export interface ProductPageable {
    page: number;
    size: number;
    category? :number;
    sort: string;
    direction:string;
}