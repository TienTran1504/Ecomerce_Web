import logo from './logo.svg';

import './App.css';
import Navigation from './customer/components/Navigation/Navigation.jsx';
import HomePage from './customer/pages/HomePage/HomePage';
import Footer from './customer/components/Footer/Footer';
import Product from './customer/components/Product/Product.jsx';
import ProductDetails from './customer/components/ProductDetails/ProductDetails.jsx';
import Cart from './customer/components/Cart/Cart.jsx';
import Checkout from './customer/components/Checkout/Checkout.jsx';
import Order from './customer/components/Order/Order.jsx';
import OrderDetail from './customer/components/Order/OrderDetail.jsx';
import { Route, Routes } from 'react-router-dom';
import CustomerRouters from './routers/CustomerRouters.jsx';
import AdminRouters from './routers/AdminRouters.jsx';

function App() {
  return (
    <div className="">
      <Routes>
        <Route path='/*' element={<CustomerRouters />} />
        <Route path='/admin/*' element={<AdminRouters />}></Route>
      </Routes>
    </div>
  );
}

export default App;
