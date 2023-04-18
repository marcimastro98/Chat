import "primeicons/primeicons.css";
import "primereact/resources/primereact.css";
import "primeflex/primeflex.css";
import "./MenubarDashboard.css";
import logo from '../../logo.svg';
import { useState } from "react";
import React from "react";
import { Menubar } from "primereact/menubar";
import { InputText } from "primereact/inputtext";
import { CgCrown } from "react-icons/cg";


const MenubarDashboard = (props) => {
  const [premium, setPremium] = useState(props.status);

  const items = [
    {
      label: "Profile",
      icon: "pi pi-fw pi-user",
      visible: !!premium,
      items: [
        {
          label: "Change Profile Pic",
          icon: "pi pi-fw pi-user-plus",
        },
        {
          label: "Delete Profile",
          icon: "pi pi-fw pi-user-minus",
        },
        {
          label: "Users Stats",
          icon: "pi pi-fw pi-users",
        },
      ],
    },
    {
      label: "Rooms",
      icon: "pi pi-fw pi-file",
      visible: !!premium,
      items: [
        {
          label: "New Room",
          icon: "pi pi-fw pi-plus",
        },
        {
          label: "Delete Room",
          icon: "pi pi-fw pi-trash",
        },
        {
          separator: true,
        },
        {
          label: "My Rooms List",
          icon: "pi pi-fw pi-list",
        },
        {
          label: "Room Stats",
          icon: "pi pi-fw pi-filter",
        },
      ],
    },
    {
      label: "Logout",
      icon: "pi pi-fw pi-power-off",
      url: '/'
    },
  ];

  const start = (
    <img
      alt="logo"
      src={logo}
      onError={(e) =>
      (e.target.src =
        "https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png")
      }
      height="40"
      className="mr-2"></img>
  );
  const end = (
    <div className="flex flex-row">
      <div className="flex align-items-center justify-content-center relative right-25">
        {props.status ? (
          <div className="vip">
            <CgCrown
              style={{
                position: "relative",
                top: "2px",
                right: "3px",
                color: "yellow",
              }}
              className="crown"
            />
            PREMIUM
          </div>
        ) : (
          <div className="free">FREE</div>
        )}
      </div>
      <div className="flex align-items-center justify-content-center">
        <InputText placeholder="Search" type="text" />
      </div>
    </div>
  );

  return (
    <div className="container-menu">
      <Menubar model={items} start={start} end={end} />
    </div>
  );
};

export default MenubarDashboard;
