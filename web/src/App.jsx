import SideBar from "./components/SideBar";

function App() {
  return (
    <div className="flex">
     <SideBar />
      <div className="flex-1 min-h-screen bg-blue-200 flex items-center justify-center">
        <h1 className="text-3xl fon">My Cloud Storage, Stay Productive</h1>
      </div>
    </div>
  );
}

export default App;
