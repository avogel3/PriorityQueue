require_relative 'node'

RSpec.describe Node do
    it { should respond_to(:name) }
    it { should respond_to(:priority) } 
end
