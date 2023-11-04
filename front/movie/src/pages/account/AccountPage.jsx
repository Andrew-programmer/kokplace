import React from 'react';
import { useForm, Controller } from 'react-hook-form';
import { NavBar } from '../../components/NavBar';
import { useEffect } from 'react';
import { $authHost } from '../../http/httpService';
import { useState } from 'react';
import { Button, Container, Form, Modal } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

export const AccountPage = () => {
  const { control, handleSubmit, formState: { errors } } = useForm();
  const [info, setInfo] = useState(null);
  const [editIsOpen, setEditIsOpen] = useState(false);
  const [file, setFile] = useState();

  const navigate = useNavigate()

  const handleCloseModal = () => {
    setEditIsOpen(false);
  };

  useEffect(() => {
    $authHost("Companies/info").then(res => {
      const info = res.data;
      console.log(info)
      setInfo(res.data);
    }).catch(c => navigate('/'));
  }, []);

  console.log(editIsOpen);

  return (
    <div>
      <NavBar></NavBar>
      <section style={{ backgroundColor: '#eee' }}>
        <div className="container py-5">
          <div className="row">
            <div className="col">
              <nav aria-label="breadcrumb" className="bg-light rounded-3 p-3 mb-4">
                Profile of your company
              </nav>
            </div>
          </div>

          <div className="row">
            <div className="col-lg-4">
              <div className="card mb-4">
                <div  style={{height: '330px'}} className="card-body text-center">
                  <img src={info?.logo ? "data:image/png;base64," + info.logo : "https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"} alt="avatar"
                    className="rounded-circle img-fluid" style={{ width: '150px', height: '150px' }} />
                  <h5 className="my-3">{info?.name}</h5>
                  <p className="text-muted mb-4">{info?.address}</p>
                  <div className="d-flex justify-content-center">
                    <button type="button" onClick={() => setEditIsOpen(true)} className="btn btn-primary">Edit profile</button>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-lg-8">
              <div className="card mb-4">
                <div style={{ height: '200px' }} className="card-body">
                  <div className="p-2 row">
                    <div className="col-sm-3">
                      <p className="mb-0">Name</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{info?.name}</p>
                    </div>
                  </div>
                  <div className="p-2 row">
                    <div className="col-sm-3">
                      <p className="mb-0">Address</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{info?.address}</p>
                    </div>
                  </div>
                  <div className="p-2 row">
                    <div className="col-sm-3">
                      <p className="mb-0">Login</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{info?.login}</p>
                    </div>
                  </div>
                  <div className="p-2 row">
                    <div className="col-sm-3">
                      <p className="mb-0">Password</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">***********</p>
                    </div>
                  </div>
                </div>
              </div>
              <div className="row">
                <div className="col-md-6">
                  <div className="card mb-4 mb-md-0">
                    <div className="card-body">
                      <p className="mb-4"><span className="text-primary font-italic me-1">Add cinema</span></p>
                      <div className="row">
                        <div className="col-sm-6">
                          <p className="mb-0">Cinemas count</p>
                        </div>
                        <div className="col-sm-6">
                          <p className="text-muted mb-0">{info?.cinemas?.length}</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="col-md-6">
                  <div className="card mb-4 mb-md-0">
                    <div className="card-body">
                      <p className="mb-4"><span className="text-primary font-italic me-1">Add hall</span></p>
                      <div className="row">
                        <div className="col-sm-6">
                          <p className="mb-0">Halls count</p>
                        </div>
                        <div className="col-sm-6">
                          <p className="text-muted mb-0">{info?.cinemas?.reduce((total, movieTheater) => total + movieTheater.halls.length, 0)}</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}
