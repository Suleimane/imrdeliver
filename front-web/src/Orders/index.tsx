import { useEffect, useState } from 'react';
import { fetchProducts } from './Api';

import ProductsList from "./ProductsList";
import SteosHeaders from "./StepsHeaders";
import "./styles.css";

function Orders(){

    const [products, setProducts] = useState([]);

   useEffect(() => {
      fetchProducts()
      .then(response => setProducts(response.data))
      .catch(error => console.log(error))
   }, []);

    return(
       <div className="orders-container">
           <SteosHeaders />
           <ProductsList products={products} />
       </div>
    );
}

export default Orders;