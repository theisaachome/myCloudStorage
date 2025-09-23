import React, { useState } from "react";
import { motion } from "framer-motion";
import { FaHome, FaUser, FaCog, FaBars } from "react-icons/fa";
import { MenuItems } from "./SideBarData";

const SideBar = () => {
  const [isOpen, setIsOpen] = useState(false);
  return (
    <div>
      <motion.div
        initial={{ width: 60 }}
        animate={{ width: isOpen ? 240 : 60 }}
        transition={{ duration: 0.3 }}
        className="bg-gray-800 text-white h-screen p-4 flex flex-col space-y-4"
      >
        <button>
            <FaBars onClick={() => setIsOpen(!isOpen)} />
        </button>
      <button>
        <nav className="flex flex-col gap-6 mt-10">
          {MenuItems.map((item, index) => (
            <div key={index} className="flex items-center space-x-4">
              <div className="text-xl">{item.icon}</div>
              {isOpen && <span className="text-lg">{item.title}</span>}
            </div>
          ))}
        </nav>
      </button>
      </motion.div>
    </div>
  );
};

export default SideBar;
