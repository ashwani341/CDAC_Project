import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import Home from './pages/Home';
import SignIn from './pages/SignIn';
import Updateprofile from './pages/UpdateProfile';

import {BrowserRouter, Routes, Route} from "react-router-dom";
import BlogDetail from './pages/BlogDetail';
import AddBlog from './pages/AddBlog';
import Error from './pages/Error'
import NavBar from './components/NavBar';
import Footer from './components/Footer';
import MyBlogs from './pages/MyBlogs';

function App() {
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/addBlog' element={<AddBlog />} />
          <Route path='/blogs' element={<Home />} />
          <Route path='/blogDetails/:id' element={<BlogDetail />} />
          <Route path='/signIn' element={<SignIn />} />
          <Route path='/updateProfile' element={<Updateprofile />} />
          <Route path='/myBlogs' element={<MyBlogs />} />

          <Route path='/*' element={<Error />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
