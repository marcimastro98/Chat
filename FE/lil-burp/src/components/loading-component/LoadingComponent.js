import './LoadigComponent.css'
const LoadingComponent = () => {
    return (
        <>
            <div className="loading-container">
                <div className='letters-container'>
                    <div className='spinner'></div>
                    <div className='letters'>
                        <div className='l-letter'>L</div>
                        <div className='b-letter'>B</div>
                    </div>
                </div>
            </div>

        </>
    )
}
export default LoadingComponent;