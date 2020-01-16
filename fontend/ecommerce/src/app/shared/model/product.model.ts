export interface Product {
    name: string;
	description: string;
	price: number;
    categoryId: number;
    photos: Photo[];
}

export interface Photo {
    image: string;
}