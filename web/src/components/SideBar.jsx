import React, { useState } from "react";
import { motion } from "framer-motion";
import { FaHome, FaUser, FaCog, FaBars } from "react-icons/fa";

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
          <FaHome /> Home
        </button>
        <button>
          <FaUser /> Profile
        </button>
        <button>
          <FaCog /> Settings
        </button>
      </motion.div>
    </div>
  );
};

export default SideBar;
