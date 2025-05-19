import React, { useEffect, useState } from 'react'
import axios from "axios"
function Catalog() {
    const [items, setItems] = useState([])
    useEffect(() => {
        const fetchItems = async () => {
            try {
                const response = await axios.get("/getAllItems");
                console.log("Fetched items: ", response.data);
                setItems(response.data)

            }
            catch (error) {
                console.log("error retrieving the data");

            }
        };
        fetchItems();
    },[])
    return (
        <>
            <div className="container mt-4">
                <h2>Grocery catalog</h2>
                {
                  items.length>0 ?
                  (
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th>Item Id</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Category</th>
                            </tr>
                        </thead>
                        <tbody>
                            {items.map(item=>(
                            <tr key ={item.id}>
                                <td>{item.id}</td>
                                <td>{item.name}</td>
                                <td>{item.price}</td>
                                <td>{item.category}</td>
                            </tr>
                            ))}
                        </tbody>
                    </table>
                  ) :
                  <p>No items found</p>

                }
            </div>
        </>
    )
}

export default Catalog